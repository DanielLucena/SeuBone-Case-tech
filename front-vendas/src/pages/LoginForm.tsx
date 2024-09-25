import { useForm, SubmitHandler } from "react-hook-form"

type Inputs = {
  login: string
  senha: string
}
function LoginForm() {
    const {
        register,
        handleSubmit,
        watch,
        formState: { errors },
      } = useForm<Inputs>()
      const onSubmit: SubmitHandler<Inputs> = (data) => console.log(data)
    
      console.log(watch("login")) // watch input value by passing the name of it
    
      return (
        /* "handleSubmit" will validate your inputs before invoking "onSubmit" */
        <form onSubmit={handleSubmit(onSubmit)} className="">
          {/* register your input into the hook by invoking the "register" function */}
          <input defaultValue="test" {...register("login")} />
    
          {/* include validation with required or other standard HTML validation rules */}
          <input {...register("senha", { required: true })} />
          {/* errors will return when field validation fails  */}
          {errors.senha && <span>This field is required</span>}
    
          <input type="submit" />
        </form>
      )
}

export default LoginForm