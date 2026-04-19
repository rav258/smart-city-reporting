export const useAuth = () => {
  const saveToken = (token: string) => {
    localStorage.setItem("token", token)
  }

  const getToken = () => {
    return localStorage.getItem("token")
  }

  const logout = () => {
    localStorage.removeItem("token")
  }

  return { saveToken, getToken, logout }
}