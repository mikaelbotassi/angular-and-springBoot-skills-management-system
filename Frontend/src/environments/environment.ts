// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
    production: false,
    apiUrl: '/api/',
    auth: {
        baseUrl: '',
        loginUrl: '/api/sso/login',
        logoutUrl: '/api/logout',
        detailsUrl: '/api/user/details',
        tokenValidationUrl: '/api/token/validate',
        storage: localStorage,
        userStorageIndex: 'user',
        loginSuccessRoute: '/#/login-success'
    }
};
<<<<<<< HEAD

export const API_PATH = '/api/'
=======
>>>>>>> cfb7427820b1bf5f102d0c984834dd4b8215b3fd
