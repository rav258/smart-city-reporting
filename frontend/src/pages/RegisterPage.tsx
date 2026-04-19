import AuthForm from "../components/AuthForm"
import { registerRequest } from "../api/authApi"
import { useNavigate } from "react-router-dom"

const RegisterPage = () => {
  const navigate = useNavigate()

  const handleRegister = async (data: any) => {
    await registerRequest(data)
    navigate("/login")
  }

  return <AuthForm title="Register" onSubmit={handleRegister} />
}

export default RegisterPage