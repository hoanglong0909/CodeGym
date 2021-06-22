const imgPosition = document.querySelectorAll(".aspect-ratio-169 img");
const imgContainer = document.querySelector(".aspect-ratio-169");
let imgNumer = imgPosition.length;
let index = 0;
imgPosition.forEach(function (image, index) {
    image.style.left = index * 100 + "%";
});
// Hàm tự đông
function imgSlide() {
    index++;
    if (index >= imgNumer) {
        index = 0;
    }
    imgContainer.style.left = "-" + index * 100 + "%";
}
// set time
setInterval(imgSlide, 5000);
