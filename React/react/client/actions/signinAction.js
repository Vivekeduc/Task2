import axios from 'axios';

export function userSignin(username,password)
{
    return dispatch=>{
        return axios.get(`http://localhost:6336/getuserbyusername/?username=${username}&password=${password}`);
    }
}