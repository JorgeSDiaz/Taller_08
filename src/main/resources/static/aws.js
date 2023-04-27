const aws = (() => {
    import {
        CognitoUserPool
    } from 'amazon-cognito-identity-js';

    const poolData = {
        UserPoolId: 'tu_user_pool_id',
        ClientId: 'tu_client_id',
    };

    const userPool = new CognitoUserPool(poolData);

    return {
        userPool: userPool
    }
})()
