import axios from 'axios';

export function userSignup(data)
{
    return dispatch=>{
        return  axios.get(`http:/localhost:6336/adduser`,data);
}


}
