const client = (() => {
    // Private
    const resource = "http://54.226.230.192:5000/v1/user";

    // Public
    return {
        login: (username, password) => {
            data = {
                username: username,
                password: password
            }

            return new Promise(
                (resolve, reject) => {
                    $.ajax({
                        url: resource + "/log-in",
                        contentType: "application/json",
                        method: "POST",
                        data: JSON.stringify(data),
                        success: (res) => resolve(res),
                        error: (err) => reject(err)
                    });
                })
        }
    }
})();