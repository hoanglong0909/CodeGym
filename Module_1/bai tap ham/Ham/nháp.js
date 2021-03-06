function Rectangle(width, height) {
    this.width = width;
    this.height = height;

    this.setWidth = function (width) {
        this.width = width;
    };

    this.setHeight = function (height) {
        this.height = height;
    };

    this.getAre = function () {
        return this.width * this.height;
    };

    this.getPerimeter = function () {
        return this.width * this.height * 2;
    };

    this.changeSize = function () {
        let width = +prompt("Width");
        let height = +prompt("Height");
        this.setWidth(width);
        this.setHeight(height);
    };

    this.draw = function () {
        let canvas = document.getElementById("myCanvas");
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        canvas.style = "border 1 px soild blue";
        let ctx = canvas.getContext("2d");
        ctx.translate(window.innerWidth / 2, window.innerHeight / 2);
        ctx.rect(0 - width / 2, 0 - height / 2, this.width, this.height);
        ctx.fill();
        alert(` S = ${this.getAre()} C = ${this.getPerimeter()}`);
    };
}

(function () {
    let rect = new Rectangle(100, 200);
    rect.draw();
    rect.changeSize();
    rect.draw();
})();
