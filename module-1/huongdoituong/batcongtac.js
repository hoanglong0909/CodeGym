function changeImage() {
    var image = document.getElementById("myImage");
    if (image.src.match("bat.gif")) {
        image.src = "/image/tat.gif";
    } else {
        image.src = "/image/bat.gif";
    }
}
