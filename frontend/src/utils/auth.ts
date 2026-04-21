interface User {
  token: string
  role: string
}

const parseToken = (token: string): User | null => {
  try {
    const payload = JSON.parse(atob(token.split(".")[1]))
    return {
      token,
      role: payload.role,
    }
  } catch {
    return null
  }
}

export const auth = {
  getUser: (): User | null => {
    const token = localStorage.getItem("token")
    if (!token) return null
    return parseToken(token)
  },

  login: (token: string) => {
    localStorage.setItem("token", token)
  },

  logout: () => {
    localStorage.removeItem("token")
  },

  isAuthenticated: (): boolean => {
    return !!localStorage.getItem("token")
  },

  isAdmin: (): boolean => {
    const user = auth.getUser()
    return user?.role === "admin"
  },
}