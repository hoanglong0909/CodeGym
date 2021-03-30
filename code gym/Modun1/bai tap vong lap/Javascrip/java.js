function send() {
    var a = document.getElementById("to").value;
    var b = document.getElementById("from").value;
    var c = parseFloat(document.getElementById("amount").value);
    console.log(c);
    if (a == "VietNam" && b == "USD") {
        document.write("Result = " + c * 23000 + " VND");
    } else if (a == "VietNam" && b == " VietNam") {
        document.write("Result = " + c + " VND");
    } else if (a == "USD" && b == "USD") {
        document.write("Result = " + c + " USD");
    } else document.write("Result = " + c / 23000 + " USD");
}
