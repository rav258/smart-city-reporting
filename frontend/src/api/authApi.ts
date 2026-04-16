const BASE_URL = "http://localhost:3000/api/auth"

export const loginRequest = async (data: {
  username: string
  password: string
}) => {
  const res = await fetch(`${BASE_URL}/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })

  const result = await res.json()

  if (!res.ok) {
    throw new Error(result.message || "Login failed")
  }

  return result
}

export const registerRequest = async (data: {
  username: string
  password: string
}) => {
  const res = await fetch(`${BASE_URL}/register`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })

  const result = await res.json()

  if (!res.ok) {
    throw new Error(result.message || "Registration failed")
  }

  return result
}