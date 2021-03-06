
function addNewCustomer() {
    let id = $('#id').val();
    let name = $('#name').val();
    let email = $('#email').val();
    let phone = $('#phone').val();
    let address = $('#address').val();
    let country_id = $('#country').val();

    let newCountry = {
        id: country_id
    }

    let newCustomer = {
        id: id,
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
            $('#smartphoneList tbody').prepend(' <tr>\n' +
                '      <td>' + customer.id + '</td>\n' +
                '      <td>' + customer.name + '</td>\n' +
                '      <td>' + customer.email + '</td>\n' +
                '      <td>' + customer.phone + '</td>\n' +
                '      <td>' + customer.address + '</td>\n' +
                '      <td>' + customer.country.name + '</td>\n' +
                '      <td><a class="editCustomer" href="' + customer.id + '"><i class="fas fa-edit"></i></a></td>\n' +
                '      <td><a class="deleteCustomer" href="' + customer.id + '"><i class="fas fa-trash-alt"></i></a></td>\n' +
                '    </tr>');
            //sư kiện nào thực hiện Ajax
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
                    }
                })
            })
        }
    });
}

$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
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
    $('.updateCustomer').on('click', function (event) {
        let id = $(this).parent().find('#id').val();
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
            }
        })
    })
})

function editCustomer(){
    let id = $('#upId').val();
    let name = $('#upName').val();
    let email = $('#upEmail').val();
    let phone = $('#upPhone').val();
    let address = $('#upAddress').val();
    let country = { "id": $('#upCountry').val() };
    //
    // let newCountry = {
    //     country: country
    // }

    let newCustomer = {
        name: name,
        email: email,
        phone: phone,
        address: address,
        country: country
    }
    console.log(newCustomer);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newCustomer),
        url: '/customers/edit/'+id,

        success: function (customer) {
            $('#smartphoneList tbody').prepend(' <tr>\n' +
                '      <td>' + customer.id + '</td>\n' +
                '      <td>' + customer.name + '</td>\n' +
                '      <td>' + customer.email + '</td>\n' +
                '      <td>' + customer.phone + '</td>\n' +
                '      <td>' + customer.address + '</td>\n' +
                '      <td>' + customer.country.name + '</td>\n' +
                '      <td><a class="editCustomer" href="' + customer.id + '"><i class="fas fa-edit"></i></a></td>\n' +
                '      <td><a class="deleteCustomer" href="' + customer.id + '"><i class="fas fa-trash-alt"></i></a></td>\n' +
                '    </tr>');
        }
    });
}
