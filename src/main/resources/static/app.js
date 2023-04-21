const app = (() => {
    // Private
    const api = client;

    const logIn = () => {
        let username = document.getElementById("first-name").value;
        let password = document.getElementById("password").value;
        client.login(username, password).then((data) => {
            window.location.assign("https://youtu.be/dQw4w9WgXcQ");
        }).catch((err) => {
            alert(JSON.parse(err.responseText).error);
        });
    }

    // Public
    return {
        logIn: logIn
    };
})();