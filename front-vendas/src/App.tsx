// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import { useEffect, useState } from 'react';
import './App.css'
import ProdutosPage from './pages/ProdutosPage'
import NavBar from './components/NavBar';
import { LoginForm } from './pages/LoginForm';
import PedidoForm from './pages/PedidoForm';
import PedidosPage from './pages/PedidosPage';
import PedidoDetalhes from './pages/PedidoDetalhes';
// import { YouTubeForm } from './pages/YouTubeForm'

export type DetailsProps = {
  id: number
}

export type PageProps = {
  onDetails : (details: DetailsProps) => void;
}
function App() {
  // const [count, setCount] = useState(0)
  const [componentToShow, setComponentToShow] = useState<string>("produto");

  const [detailsToShow ,setDetailsToShow] = useState<DetailsProps | null>();

  useEffect(() => setComponentToShow('details'), [detailsToShow]);

  return (
    <>
    <div className='min-h-screen bg-slate-700'>
    <NavBar
          onNavigate={setComponentToShow}
          // isLoggedIn={isLoggedIn}
        />
      <div className=" flex flex-col gap-4 items-center px-6 py-4">
        
        {componentToShow === "login" && <LoginForm/>}

        {componentToShow === "produtos" && <ProdutosPage/>}
        {componentToShow === "pedidoForm" && <PedidoForm/>}
        {componentToShow === "pedidos" && <PedidosPage
        onDetails={setDetailsToShow}/>}
        {componentToShow === "details" && <PedidoDetalhes
        id={detailsToShow?.id}/>}

      </div>
    </div>
    {/* <ProdutosPage/> */}
    </>
  )
}

export default App
