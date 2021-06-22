<body onload="docReady()"></body>;
function upmyfuction() {
    let elemnt = document.getElementById("nobita");
    elemnt.style.top = parseInt(element.style.top) - 5 + "px";
}
function downmyfuction() {
    let elemnt = document.getElementById("nobita");
    elemnt.style.down = parseInt(element.style.down) + 5 + "px";
}
function leftmyfuction() {
    let elemnt = document.getElementById("nobita");
    elemnt.style.left = parseInt(element.style.left) - 5 + "px";
}
function rightmyfuction() {
    let elemnt = document.getElementById("nobita");
    elemnt.style.right = parseInt(element.style.right) + 5 + "px";
}
function move(evt) {
    switch (evt.keycode) {
        case 37:
            leftmyfuction();
            break;
        case 39:
            rightmyfuction();
            break;
        case 38:
            upmyfuction();
            break;
        case 40:
            downmyfuction();
            break;
    }
}
function docReady() {
    window.addEventListener("keydown", moveSelection);
}
