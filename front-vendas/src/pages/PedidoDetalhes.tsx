/* eslint-disable @typescript-eslint/no-explicit-any */
import { useEffect, useState } from 'react'
import { Pedido } from './PedidosPage';
import { request } from '../helpers/axios_helper';


type DetailsPageProps = {
    id: number | undefined
  }
function PedidoDetalhes(props: DetailsPageProps) {
    const [pedido, setPedido] = useState<Pedido>()
//   const [reducerValue, forceUpdate] = useReducer((x) => x + 1, 0);


  useEffect(() => {
    const fetchData = async () => {
      if(props.id !== null){
        try {
          const response = await request("GET", `/pedido/${props.id}`, {});
          setPedido(response.data);
        } catch (error: any) {
          console.error(error);
        }
      }
    };
    fetchData();
  }, []);
  return (
    <>
    <ul>
        <li>Id: {pedido?.id}</li>
        <li>Soma: {pedido?.soma}</li>
        <li>Valor Frete: {pedido?.valorFrete}</li>
        <li>Prazo: {pedido?.prazo}</li>
        <li>Desconto: {pedido?.desconto}</li>
        <li>Forma de Pagamento: {pedido?.formaPagamento}</li>
        <li>Status: {pedido?.status}</li>
        <li>Vendedor: {pedido?.vendedor}</li>
        <li>Itens: 
            <ul>
                {pedido?.itens.map((item) => 
                    <li key={item.produto_id}>Produto: {item.produto_id} Quantidade: {item.quantidade}</li>
                )}
            </ul>
        </li>
    </ul>
    </>
  )
}

export default PedidoDetalhes