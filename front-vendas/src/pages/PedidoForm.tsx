/* eslint-disable @typescript-eslint/no-explicit-any */
import { DevTool } from '@hookform/devtools';
import { useEffect, useState } from 'react'
import { useFieldArray, useForm } from 'react-hook-form';
import { request } from '../helpers/axios_helper';

// let renderCount = 0;

type FormValues = {
    valorFrete: number;
    prazo: string;
    itens: {
        produto_id: number;
        quantidade: number;
    }[],
    desconto: number;
    formaPagamento: string
};

interface Produto {
    id: number;
    SKU: string;
    produto: string;
    preco_cheio: number;
    preco_descontado: number;
  }

const prazoOptions = [ "PADRAO", "TURBO", "SUPER_TURBO" ] ;
const formaPagamentoOptions = [  "CARTAO_DEBITO", "CARTAO_CREDITO", "PIX", "BOLETO" ] ;

function PedidoForm() {
    const form = useForm<FormValues>();
    const { register, control, handleSubmit} = form;
    const [produtos, setProdutoes] = useState<Produto[]>([]);
    // const [reducerValue, forceUpdate] = useReducer((x) => x + 1, 0);


    const {fields, append, remove} = useFieldArray({
        name: "itens",
        control
    })

    useEffect(() => {
        const fetchData = async () => {
            try {
            const response = await request("GET", "/produto", {});
            setProdutoes(response.data);
              console.log(response.data);
            } catch (error: any) {
            console.error(error);
            }
        };
    
        fetchData();
        }, []);

    const onSubmit = async (body: FormValues) => {
      console.log(body);
      try {
        const response = await request("POST", "/pedido", {
            valorFrete: body.valorFrete,
            prazo: body.prazo,
            desconto: body.desconto,
            formaPagamento: body.formaPagamento,
            itens: body.itens
        });
        console.log(response.data);
        alert("Pedido criado com sucesso, id: " + response.data.id);

      } 
      catch (error) {
       
        console.error(error);
      
      }
      
    }
    // renderCount++;
    return (
      <div>
        {/* <h1>Criar Pedido ({renderCount/2})</h1> */}
        <h2>Criar Pedido:</h2>
  
        <form onSubmit={handleSubmit(onSubmit)} noValidate>
          <label htmlFor="valorFrete">valorFrete</label>
          <input type="number" id="valorFrete" {...register("valorFrete")}/>
  
          <label htmlFor="prazo">prazo</label>
          {/* <input type="text" id="prazo" {...register("prazo")}/> */}
          <select 
            {...register("prazo")}>
            {/* <option value="">Selecione</option> */}
                {prazoOptions?.map((opcao) => (
                <option key={opcao} value={opcao}>
                    {opcao}
                </option>
                ))}
            </select>

          <label htmlFor="desconto">desconto</label>
          <input type="number" id="desconto" {...register("desconto")}/>

          <label htmlFor="formaPagamento">formaPagamento</label>
          {/* <input type="text" id="formaPagamento" {...register("formaPagamento")}/> */}
          <select 
            {...register("formaPagamento")}>
            {/* <option value="">Selecione</option> */}
                {formaPagamentoOptions?.map((opcao) => (
                <option key={opcao} value={opcao}>
                    {opcao}
                </option>
                ))}
            </select>

          <div>
                <label>Lista de produtos</label>
                <div>
                    {fields.map((field, index) => {
                            return(
                                <div className='form-control' key={field.id}>
                                    <div>
                                        <label htmlFor="itens.${index}.produto_id">produto</label>
                                        {/* <input 
                                        type="number" 
                                        {...register(`itens.${index}.produto_id` as const)}
                                        /> */}
                                        <select 
                                            {...register(`itens.${index}.produto_id` as const)}>
                                            {/* <option value="">Selecione</option> */}
                                                {produtos?.map((opcao) => (
                                                <option key={opcao.id} value={opcao.id}>
                                                    {opcao.SKU}
                                                </option>
                                                ))}
                                            </select>
                                    </div>
                                    <div>
                                        <label htmlFor="itens.${index}.quantidade">quantidade</label>
                                        <input
                                        type='number'
                                        {...register(`itens.${index}.quantidade` as const)}
                                        />
                                    </div>
                                    {
                                        index >= 0 && (
                                            <button type='button' 
                                            onClick={() => remove(index)}>Remove</button>
                                        )
                                    }
                                </div>
                            );
                        })
                    }
                    <button type='button' 
                    onClick={() => append({produto_id: 0, quantidade:0})}>Add Produto</button>
                </div>
            </div>
  
          <button>Submit</button>
        </form>
        <DevTool control={control}/>
      </div>
    );
}

export default PedidoForm
