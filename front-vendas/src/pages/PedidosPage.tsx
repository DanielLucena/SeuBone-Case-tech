/* eslint-disable @typescript-eslint/no-explicit-any */
import { useEffect, useReducer, useState } from 'react'
import { request, setAuthHeader } from '../helpers/axios_helper';
// import { NavBarProps } from '../components/NavBar';
import { PageProps } from '../App';

export interface Pedido {
    id: number;
    soma: number;
    valorFrete: number;
    prazo: string;
    desconto: number;
    formaPagamento: string;
    status: string;
    itens: {
        produto_id: number;
        quantidade: number;
    }[];
    vendedor: string;
  }

function PedidosPage(props: PageProps) {
    const [pedidos, setPedidos] = useState<Pedido[]>([]);
    const [reducerValue, forceUpdate] = useReducer((x) => x + 1, 0);

    useEffect(() => {
    const fetchData = async () => {
        try {
        const response = await request("GET", "/pedido", {});
        setPedidos(response.data);
          console.log(response.data);
        } catch (error: any) {
        if (error.response.status === 401) {
            setAuthHeader(null);
        } else {
            setPedidos([error.response.code]);
        }
        }
    };

    fetchData();
    }, [reducerValue]);

  function handleAprovarButtonClick(pedido: Pedido): void {
    request("PUT", `/pedido/revisar/${pedido.id}`, {
      status: "APROVADO",
    })
    .catch(()=>{
      alert( "Você não tem permissão para realizar esta ação");
    })
    .then(() => {
      forceUpdate();
    });
  }

  function handleRejeitarButtonClick(pedido: Pedido): void {
    request("PUT", `/pedido/revisar/${pedido.id}`, {
      status: "RECUSADO",
    })
    .catch(()=>{
      alert( "Você não tem permissão para realizar esta ação");
    })
    .then(() => {
      forceUpdate();
    });
  }

    return (
    <div>
        <h2>Listagem de Produtos</h2>
      <table className="custom-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Soma</th>
            <th>Frete</th>
            <th>Prazo</th>
            <th>Desconto</th>
            <th>Pagamento</th>
            <th>Status</th>
            <th>Vendedor</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {pedidos.map((pedido) => (
            <tr key={pedido.id}>
              <td>{pedido.id}</td>
                <td>{pedido.soma}</td>
                <td>{pedido.valorFrete}</td>
                <td>{pedido.prazo}</td>
                <td>{pedido.desconto}</td>
                <td>{pedido.formaPagamento}</td>
                <td>{pedido.status}</td>
                <td>{pedido.vendedor}</td>
              <td>
                <button
                  type="button"
                  className="btn btn-secondary"
                  onClick={() => handleAprovarButtonClick(pedido)}
                >
                  Aprovar
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => handleRejeitarButtonClick(pedido)}
                >
                  Rejeitar
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => props.onDetails({id:pedido.id})}
                >
                  Detalhes
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button className="btn btn-primary" onClick={forceUpdate}>
        Recarregar
      </button>
    </div>
    )
}

export default PedidosPage