import { useEffect, useState } from 'react'

function App() {
  const [estado, setEstado] = useState('comprobando')

  useEffect(() => {
    fetch('/actuator/health')
      .then((respuesta) => respuesta.json())
      .then((datos) => setEstado(datos.status === 'UP' ? 'conectado' : 'error'))
      .catch(() => setEstado('error'))
  }, [])

  return (
    <main>
      <h1>ReciboFácil</h1>
      {estado === 'comprobando' && <p>Comprobando conexión con el servidor...</p>}
      {estado === 'conectado' && <p>Conectado con el servidor</p>}
      {estado === 'error' && (
        <p>No se pudo conectar con el servidor. Revisa que el backend esté encendido.</p>
      )}
    </main>
  )
}

export default App