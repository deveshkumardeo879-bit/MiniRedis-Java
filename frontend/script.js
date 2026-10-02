const API_URL = "http://localhost:8080/api";


async function setValue() {

    const key = document.getElementById("setKey").value;
    const value = document.getElementById("setValue").value;

    const response = await fetch(
        `${API_URL}/set?key=${encodeURIComponent(key)}&value=${encodeURIComponent(value)}`,
        {
            method: "POST"
        }
    );

    const result = await response.text();

    showMessage("SET: " + result);
}


async function getValue() {

    const key = document.getElementById("getKey").value;

    const response = await fetch(
        `${API_URL}/get?key=${encodeURIComponent(key)}`
    );

    const result = await response.text();

    document.getElementById("getResult").innerText =
        "Result: " + result;
}


async function setTTL() {

    const key = document.getElementById("ttlKey").value;
    const value = document.getElementById("ttlValue").value;
    const seconds = document.getElementById("ttlSeconds").value;

    const response = await fetch(
        `${API_URL}/setex?key=${encodeURIComponent(key)}&seconds=${encodeURIComponent(seconds)}&value=${encodeURIComponent(value)}`,
        {
            method: "POST"
        }
    );

    const result = await response.text();

    showMessage("SETEX: " + result);
}


async function deleteValue() {

    const key = document.getElementById("deleteKey").value;

    const response = await fetch(
        `${API_URL}/delete?key=${encodeURIComponent(key)}`,
        {
            method: "DELETE"
        }
    );

    const result = await response.text();

    showMessage("DELETE: " + result);
}


async function checkExists() {

    const key = document.getElementById("existsKey").value;

    const response = await fetch(
        `${API_URL}/exists?key=${encodeURIComponent(key)}`
    );

    const result = await response.text();

    document.getElementById("existsResult").innerText =
        "Exists: " + result;
}


function showMessage(message) {

    document.getElementById("message").innerText = message;
}