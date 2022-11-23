import React from "react";
import { useNavigate } from "react-router-dom";




const Register = () =>{

    const navigate = useNavigate()



return(

    <>

<div style={{display : "flex"  ,  justifyContent:"center" ,  marginTop:20 }}>

<div style={{border:"1px double green" ,  padding:2 ,  borderStyle:"double" }}>
<div style={{border:"1px double green" ,  padding:30 ,  borderStyle:"double" }}>


<form>
<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Full Name</label>
<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
</div>
<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Mobile</label>
<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
</div>
<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Full Address</label>
<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
</div>
<div class="mb-3">
<label for="exampleInputEmail1" class="form-label">Email address</label>
<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>
<div class="mb-3">
<label for="exampleInputPassword1" class="form-label">Password</label>
<input type="password" class="form-control" id="exampleInputPassword1" />
</div>
<div class="mb-3 form-check">
    <label class="form-check-label" for="exampleCheck1"> <i>Already have an account ? <span style={{color:"blue" , cursor:"pointer"}}  onClick={()=>navigate('/login')}> Register Here!! </span></i> </label>
  </div>
<button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
</div>
    </>
)



}

export default Register