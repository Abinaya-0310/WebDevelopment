let display = document.getElementById("display");

function appendNumber(number) {
    display.value += number;
}

function appendOperator(operator) {
    display.value += " " + operator + " ";
}

function appendDot() {
    if (!display.value.endsWith(".")) {
        display.value += ".";
    }
}

function clearDisplay() {
    display.value = "";
}

function deleteLast() {
    display.value = display.value.trim().slice(0, -1);
}
