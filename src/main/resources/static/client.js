const client = (() => {
    // Private
    const resource = "http://54.226.230.192:5000/v1";

    // Public
    const login = (username, password) => {
        let data = {
            username: username,
            password: password
        }

        return new Promise(
            (resolve, reject) => {
                $.ajax({
                    url: resource + "/user/log-in",
                    contentType: "application/json",
                    method: "POST",
                    data: JSON.stringify(data),
                    success: (res) => resolve(res),
                    error: (err) => reject(err)
                });
            }
        )
    };

    const addMessage = (author, message) => {
        let data = {
            author: author,
            message: message
        }

        return new Promise(
            (resolve, reject) => {
                $.ajax({
                    url: resource + "/message/",
                    contentType: "application/json",
                    method: "POST",
                    data: JSON.stringify(data),
                    success: (res) => resolve(res),
                    error: (err) => reject(err)
                });
            }
        );
    }

    const getMessage = () => {
        return new Promise(
            (resolve, reject) => {
                $.ajax({
                    url: resource + "/message/",
                    method: "GET",
                    success: (res) => resolve(res),
                    error: (err) => reject(err)
                })
            }
        )
    }

    return {
        login: (username, password) => {
            return login(username, password);
        },
        addMessage: (author, message) => {
            return addMessage(author, message);
        },
        getMessage: getMessage
    }
})();