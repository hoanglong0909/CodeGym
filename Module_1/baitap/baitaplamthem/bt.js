console.log("Load script ....");

class Apple {
    constructor(weight) {
        this.weight = weight;
    }

    decrease() {
        if (this.weight > 0) {
            this.weight--;
        }
    }

    isEmpty() {
        return this.weight === 0;
    }

    getWeight() {
        return this.weight;
    }
}

class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }
    isMale() {
        return this.gender === true;
    }

    setGender(gender) {
        this.gender = gender;
    }

    checkApple(apple) {
        return apple.isEmpty();
    }

    eat(apple) {
        if (apple.getWeight() > 0) {
            apple.decrease();
            this.weight++;
        }
    }

    say(message) {
        return message;
    }

    getName() {
        return this.name;
    }

    setName(name) {
        this.name = name;
    }

    getWeight() {
        return this.weight;
    }

    setWeight(weight) {
        this.weight = weight;
    }
}

let apple = new Apple(5);
let adam = new Human("Adam", true, 55);
let eva = new Human("Eva", false, 50);

const init = () => {
    document.getElementById("apple").innerHTML = apple.getWeight();
    document.getElementById("adam").innerHTML = adam.getWeight();
    document.getElementById("eva").innerHTML = eva.getWeight();
};

const update = (who) => {
    document.getElementById("apple").innerHTML = apple.getWeight();
    if (apple.isEmpty()) {
        document.getElementById("message").innerHTML = "Apple is empty";
    } else {
        if (who === "adam") {
            document.getElementById("adam").innerHTML = adam.getWeight();
        } else if (who === "eva") {
            document.getElementById("eva").innerHTML = eva.getWeight();
        }
    }
};

const eatApple = (who) => {
    who === "adam" ? adam.eat(apple) : eva.eat(apple);
    update(who);
};

init();
