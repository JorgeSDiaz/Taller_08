const app = (() => {
    // AWS.config.region = "us-east-1";
    //
    // const AmazonCognitoIdentity = AWS.CognitoIdentity;
    // const CognitoUserPool = AmazonCognitoIdentity.CognitoUserPool;
    //
    // const identityPoolId = "us-east-1:294499783189:userpool/us-east-1_SlsA4fJYR";
    // const userPoolId = "us-east-1_SlsA4fJYR";
    // const clientId = "g8kea2q2conbf66kpe8nm5kpb";
    //
    // const credentials = new AWS.CognitoIdentityCredentials({
    //     IdentityPoolId: identityPoolId
    // });

    // Private
    const api = client;
    let author = "";

    // Public
    const logIn = () => {
        let username = document.getElementById("first-name").value;
        let password = document.getElementById("password").value;

        api.login(username, password).then(
            (res) => window.location.href = "/Message.html?author=" + username
        ).catch(
            (err) => alert(JSON.parse(err.responseText).error)
    )

        // let authenticationDetails = new AuthenticationDetails({
        //     Username: username,
        //     Password: password,
        // });
        //
        // console.log(authenticationDetails);
        //
        // let userPool = new CognitoUserPool({
        //     UserPoolId: userPoolId,
        //     ClientId: clientId,
        //     Storage: window.localStorage,
        //     CognitoIdentityCredentials: credentials
        // });
        //
        // console.log(userPool);
        //
        // let cognitoUser = new CognitoUser({
        //     Username: username,
        //     Pool: userPool,
        // });
        //
        // console.log(cognitoUser);
        //
        // cognitoUser.authenticateUser(authenticationDetails, {
        //     onSuccess: (result) => {
        //         console.log('success');
        //         window.location.href = "/Message.html?author=" + username;
        //     },
        //     onFailure: (err) => {
        //         console.log('error');
        //         alert(err);
        //     },
        // });
    };

    const sendMessage = () => {
        if (author === "") {
            author = new URLSearchParams(window.location.search).get("author");
        }
        let message = document.getElementById("Message").value;

        client.addMessage(author, message).then(
            (res) => console.log(res.data)
        ).catch(
            (err) => console.log(err.error)
        );
    };

    const getMessage = () => {
        client.getMessage().then(
            (res) => {
                const del = document.querySelector("#res ul");
                if (del) {
                    del.parentNode.removeChild(del);
                }
                let list = document.createElement("ul");
                res.data.map((o) => {
                    const item = document.createElement("li");
                    item.textContent = o.author + ": " + o.message;
                    list.appendChild(item)
                });
                document.getElementById("res").appendChild(list);
            }
        ).catch(
            (err) => console.log(err)
        );

        // var cognitoUser = userPool.getCurrentUser();
        //
        // if (cognitoUser != null) {
        //     cognitoUser.getSession((err, session) => {
        //         if (err) {
        //             alert(err.message || JSON.stringify(err));
        //             return;
        //         }
        //         console.log('session validity: ' + session.isValid());
        //         console.log('access token + ' + session.getAccessToken().getJwtToken());
        //         client.getMessage().then(
        //             (res) => {
        //                 const del = document.querySelector("#res ul");
        //                 if (del) {
        //                     del.parentNode.removeChild(del);
        //                 }
        //                 let list = document.createElement("ul");
        //                 res.data.map((o) => {
        //                     const item = document.createElement("li");
        //                     item.textContent = o.author + ": " + o.message;
        //                     list.appendChild(item)
        //                 });
        //                 document.getElementById("res").appendChild(list);
        //             }
        //         ).catch(
        //             (err) => console.log(err)
        //         );
        //     })
        // } else {
        //     window.location.href = "login.html";
        // }
    }

    return {
        logIn: logIn,
        sendMessage: sendMessage,
        getMessage: getMessage
    };
})();