
function addNewCustomer() {
    let name = $('#name').val();
    let email = $('#email').val();
    let phone = $('#phone').val();
    let address = $('#address').val();
    let country_id = $('#country').val();

    let newCountry = {
        id: country_id
    }

    let newCustomer = {
        name: name,
        email: email,
        phone: phone,
        address: address,
        country: newCountry
    };
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Your work has been saved',
        showConfirmButton: false,
        timer: 1500
    })
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newCustomer),
        url: "/customers",
        success: function (customer) {
            $('#smartphoneList tbody').prepend(' <tr id="row'+ customer.id+'">\n' +
                '      <td>' + customer.id + '</td>\n' +
                '      <td>' + customer.name + '</td>\n' +
                '      <td>' + customer.email + '</td>\n' +
                '      <td>' + customer.phone + '</td>\n' +
                '      <td>' + customer.address + '</td>\n' +
                '      <td>' + customer.country.name + '</td>\n' +
                '      <td><button onclick="loadEditData('+ customer.id+',this)" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"  class=" btn btn-outline-primary" ><a><i class="fas fa-edit">Edit</i></a></button>' +
                '<input type="hidden" id="id" value="' + customer.id + '"></td>\n' +

                ' <td><button class="btn btn-outline-danger" onclick="deleteCustomer('+ customer.id+',this)">' +
                '<i class="fas fa-trash-alt"></i>Delete </button> </td>' +
                ' </tr>');
            //sư kiện nào thực hiện Ajax


            $('.updateCustomer').on('click', function (event) {
                var id = $(this).parent().find('#id').val();
                $.ajax({
                    type: 'GET',
                    url: '/customers/api/' + id,
                    success: function (customer) {
                        $('#upId').val(customer.id);
                        $('#upName').val(customer.name);
                        $('#upEmail').val(customer.email);
                        $('#upPhone').val(customer.phone);
                        $('#upAddress').val(customer.address);
                        $('#upCountry').val(customer.country.id).change();
                        $('.deleteCustomer').on('click', function (event) {
                            //lay du lieu
                            let a = $(this);
                            let customerId = a.attr("href");
                            const swalWithBootstrapButtons = Swal.mixin({
                                customClass: {
                                    confirmButton: 'btn btn-success',
                                    cancelButton: 'btn btn-danger'
                                },
                                buttonsStyling: false
                            })
                            swalWithBootstrapButtons.fire({
                                title: 'Are you sure?',
                                text: "You won't be able to revert this!",
                                icon: 'warning',
                                showCancelButton: true,
                                confirmButtonText: 'Yes, delete it!',
                                cancelButtonText: 'No, cancel!',
                                reverseButtons: true
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    swalWithBootstrapButtons.fire(
                                        'Deleted!',
                                        'Your file has been deleted.',
                                        'success'
                                    );
                                    console.log(customerId);
                                    $.ajax({
                                        type: "DELETE",
                                        //tên API
                                        url: `/customers/${customerId}`,
                                        //xử lý khi thành công
                                        success: function (data) {
                                            a.parent().parent().remove();
                                        }
                                    });
                                    //chặn sự kiện mặc định của thẻ
                                } else if (
                                    /* Read more about handling dismissals below */
                                    result.dismiss === Swal.DismissReason.cancel
                                ) {
                                    swalWithBootstrapButtons.fire(
                                        'Cancelled',
                                        'Your imaginary file is safe :)',
                                        'error'
                                    )
                                }
                            })
                            event.preventDefault();
                        });

                    }
                })
            })
        }
    });
}
function deleteCustomer(customerId,button){
    let a = button;
    // let customerId = a.attr("href");
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel!',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: "DELETE",
                url: `/customers/${customerId}`,
                //xử lý khi thành công
                success: function (data) {
                    //a.parent("tr").first().remove();
                    a.closest ('tr').remove ();
                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    );
                }
            });
            //chặn sự kiện mặc định của thẻ
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your imaginary file is safe :)',
                'error'
            )
        }
    })
    event.preventDefault();
}
function loadEditData(id){

    $.ajax({
        type: 'GET',
        url: '/customers/api/' + id,
        success: function (customer) {
            $('#exampleModalLabelSpan').text("Edit");
            $('#upId').val(customer.id);
            $('#upName').val(customer.name);
            $('#upEmail').val(customer.email);
            $('#upPhone').val(customer.phone);
            $('#upAddress').val(customer.address);
            $('#upCountry').val(customer.country.id).change();
        }
    })
    //event.preventDefault();
}
function editCustomer() {
    let id = $('#upId').val();
    let name = $('#upName').val();
    let email = $('#upEmail').val();
    let phone = $('#upPhone').val();
    let address = $('#upAddress').val();
    let country = {"id": $('#upCountry').val()};

    let newCustomer = {
        name: name,
        email: email,
        phone: phone,
        address: address,
        country: country
    }
    console.log(newCustomer);
    if (id==0){
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newCustomer),
            url: "/customers",
            success: function (customer) {
                $('#smartphoneList tbody').prepend(' <tr id="row'+ customer.id+'">\n' +
                    '      <td>' + customer.id + '</td>\n' +
                    '      <td>' + customer.name + '</td>\n' +
                    '      <td>' + customer.email + '</td>\n' +
                    '      <td>' + customer.phone + '</td>\n' +
                    '      <td>' + customer.address + '</td>\n' +
                    '      <td>' + customer.country.name + '</td>\n' +
                    '      <td><button onclick="loadEditData('+ customer.id+',this)" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"  class=" btn btn-outline-primary" ><a><i class="fas fa-edit">Edit</i></a></button>' +
                    '<input type="hidden" id="id" value="' + customer.id + '"></td>\n' +

                    ' <td><button class="btn btn-outline-danger" onclick="deleteCustomer('+ customer.id+',this)">' +
                    '<i class="fas fa-trash-alt"></i>Delete </button> </td>' +
                    ' </tr>');
                //sư kiện nào thực hiện Ajax
                $('.close-modal').click();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Your work has been saved',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }else{
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newCustomer),
            url: '/customers/edit/' + id,

            success: function (customer) {
                console.log(customer);
                $('#row' + id + ' td').remove();
                $('#row' + id).html(`
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.address}</td>
                        <td>${customer.country.name}</td>
                       <td><button onclick="loadEditData('${customer.id}')"  data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"  class="updateCustomer btn btn-outline-primary" href="' + customer.id + '"><a><i class="fas fa-edit">Edit</i></a></button><input type="hidden" id="id" value="' + customer.id + '"></td>
                      <td><button class="btn btn-outline-danger" onclick="deleteCustomer('${customer.id}',this)"   ><i
                    class="fas fa-trash-alt"></i>Delete</button></td>`);

                $('.close-modal').click();
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'You have changed successfull',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        });
    }

}
function loadAddnew(){

    $('#exampleModalLabelSpan').text("Add new");
    $('#upId').val(0);
    $('#upName').val("");
    $('#upEmail').val("");
    $('#upPhone').val("");
    $('#upAddress').val("");
    $('#upCountry').val("");
}