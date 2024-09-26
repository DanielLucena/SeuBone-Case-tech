

export type NavBarProps = {
    onNavigate: (page: string) => void;
    // isLoggedIn: boolean;
  };

  const paginas = [{
    nome: 'Produtos',
    link: 'produtos'
  }, {
    nome: 'Pedidos',
    link: 'pedidos'
  }, {
    nome: 'Login',
    link: 'login'
  }, {
    nome: 'PedidoForm',
    link: 'pedidoForm'
  }]

function NavBar(props:NavBarProps) {
    const username = localStorage.getItem('username');
  return (
    <div className='bg-slate-200 flex w-full justify-between items-center'>
        <div className='flex gap-4 w-full h-full'>
            <h1 className='pl-2 py-4'>Vendas ({username})</h1>
            <div className='flex'>
                {paginas.map((pagina) => <button className='hover:bg-slate-50 w-full px-2 py-4 h-full'key={pagina.link} onClick={() => props.onNavigate(pagina.link)}>{pagina.nome}</button>)}
            </div>
        </div>
        
    </div>
  )
}

export default NavBar