const API_URL = "https://miniredis-java-production.up.railway.app/api";


async function setValue() {

    const key = document.getElementById("setKey").value;
    const value = document.getElementById("setValue").value;

    try {

        const response = await fetch(
            `${API_URL}/set?key=${encodeURIComponent(key)}&value=${encodeURIComponent(value)}`,
            {
                method: "POST"
            }
        );

        const result = await response.text();

        showMessage("SET: " + result);

    } catch (error) {

        showMessage("SET failed: Backend connection error");

        console.error(error);
    }
}


async function getValue() {

    const key = document.getElementById("getKey").value;

    try {

        const response = await fetch(
            `${API_URL}/get?key=${encodeURIComponent(key)}`
        );

        const result = await response.text();

        document.getElementById("getResult").innerText =
            "Result: " + result;

    } catch (error) {

        document.getElementById("getResult").innerText =
            "Result: Backend connection error";

        console.error(error);
    }
}


async function setTTL() {

    const key = document.getElementById("ttlKey").value;
    const value = document.getElementById("ttlValue").value;
    const seconds = document.getElementById("ttlSeconds").value;

    try {

        const response = await fetch(
            `${API_URL}/setex?key=${encodeURIComponent(key)}&seconds=${encodeURIComponent(seconds)}&value=${encodeURIComponent(value)}`,
            {
                method: "POST"
            }
        );

        const result = await response.text();

        showMessage("SETEX: " + result);

    } catch (error) {

        showMessage("SETEX failed: Backend connection error");

        console.error(error);
    }
}


async function deleteValue() {

    const key = document.getElementById("deleteKey").value;

    try {

        const response = await fetch(
            `${API_URL}/delete?key=${encodeURIComponent(key)}`,
            {
                method: "DELETE"
            }
        );

        const result = await response.text();

        showMessage("DELETE: " + result);

    } catch (error) {

        showMessage("DELETE failed: Backend connection error");

        console.error(error);
    }
}


async function checkExists() {

    const key = document.getElementById("existsKey").value;

    try {

        const response = await fetch(
            `${API_URL}/exists?key=${encodeURIComponent(key)}`
        );

        const result = await response.text();

        document.getElementById("existsResult").innerText =
            "Exists: " + result;

    } catch (error) {

        document.getElementById("existsResult").innerText =
            "Exists: Backend connection error";

        console.error(error);
    }
}


function showMessage(message) {

    document.getElementById("message").innerText = message;
}