import axios from 'axios';

import * as environments from '../config/environments';

export const login = axios.create({
  baseURL: environments.PM_APP_URL_AUTHORIZATION,
});

export const apiDimpBackEnd = axios.create({
  baseURL: environments.PM_APP_URL_EXEMPLE,
});

/*apiDimpBackEnd.interceptors.request.use(async (config) => {
  const { access_token } = await getAccessToken();
  config.headers['authorization'] = access_token;
  return config;
});

apiExportador.interceptors.request.use(async (config) => {
  const { access_token } = await getAccessToken();
  config.headers['authorization'] = access_token;
  return config;
});
*/
