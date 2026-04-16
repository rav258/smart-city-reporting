import AuthForm from "../components/AuthForm"
import { useAuth } from "../hooks/useAuth"
import { useNavigate } from "react-router-dom"
import { loginRequest } from "../api/authApi"

const LoginPage = () => {
  const { saveToken } = useAuth()
  const navigate = useNavigate()

  const handleLogin = async (data: any) => {
    const response = await loginRequest(data)
    saveToken(response.token)
    navigate("/")
  }

  return <AuthForm title="Login" onSubmit={handleLogin} />
}

export default LoginPage
