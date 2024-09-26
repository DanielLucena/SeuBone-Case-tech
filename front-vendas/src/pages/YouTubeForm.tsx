import { useEffect } from 'react';
import { useForm, useFieldArray } from 'react-hook-form'
import {DevTool} from '@hookform/devtools'

let renderCount = 0;

type FormValues = {
    username: string;
    email: string;
    channel: string;
    social: {
        facebook: string;
        twitter: string;
     };
    phoneNumbers: string[];
    phNumbers: {
        number: string;
    }[];
    age: number;
    dob: Date
};
export const YouTubeForm = () => {

    const form = useForm<FormValues>({
            // defaultValues: async () => {
            //     const response = await fetch('https://jsonplaceholder.typicode.com/users/1');
            //     const data = await response.json();
            //     return {
            //         username: "Batman",
            //         email: data.email,
            //         channel: ""
            //     };
            // }
            defaultValues: {
                username: "Batman",
                email: "",
                channel: "",
                social: {
                    facebook: "",
                    twitter: ""
                 },
                phoneNumbers: ["",""],
                phNumbers: [
                    {
                        number: ""
                    }
                ],
                age: 0,
                dob: new Date()
            },
    });


    const { register, control, handleSubmit, formState, watch, getValues} = form;
    const {errors} = formState;
    // const {name, ref, onChange, onBlur} = register('username');

    const {fields, append, remove} = useFieldArray({
        name: "phNumbers",
        control
    })

    const onSubmit = (data: FormValues) => {
        console.log("form submitted", data);
    };

    const handleGetValues = () => {
        console.log("get values: ",getValues("social"));
    }

    useEffect(() => {
        const subscription = watch(value => {
            console.log(value);
        })
        return () => subscription.unsubscribe();
    }, [watch]);

    const watchUsername = watch("username");

    renderCount++;
    return (
      <div>
        <h1>YouTube Form ({renderCount/2})</h1>
        <h2>Watch Username: {watchUsername}</h2>
        <form onSubmit={handleSubmit(onSubmit)} noValidate>
          <label htmlFor="username">Username</label>
          <input type="text" id="username" {...register("username", {
            required: {
                value: true,
                message: "username is required"
            }
          })}/>
            <p className='error'>{errors.username?.message}</p>
          <label htmlFor="email">E-mail</label>
          <input type="email" id="email" {...register("email", {
            pattern: {
                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                message: "invalid email address"
                },
            validate: {
                notAdmin: (fieldValue) => {
                return (
                    fieldValue !== "admin@example.com"
                    || "Enter a valid email address"
                );
            },
                notBlackListed: (fieldValue) => {
                    return !fieldValue.endsWith("baddomain.com") 
                    || "Domain is blacklisted";
                }
            },
          })}
          />
            <p className='error'>{errors.email?.message}</p>
          <label htmlFor="channel">Channel</label>
          <input type="text" id="channel" {...register("channel", {
            required: {
                value: true,
                message: "channel is required"
            }
          })}/>
            <p className='error'>{errors.channel?.message}</p>

            <label htmlFor="twitter">Twitter</label>
          <input type="text" id="twitter" {...register("social.twitter", {
          })}/>
            <p className='error'>{errors.social?.twitter?.message}</p>

            <label htmlFor="facebook">Facebook</label>
          <input type="text" id="facebook" {...register("social.facebook", {
          })}/>
            <p className='error'>{errors.social?.facebook?.message}</p>

            <label htmlFor="pramary-phone">Primary Phone Number</label>
          <input type="text" id="pramary-phone" {...register("phoneNumbers.0", {
          })}/>
            <p className='error'>{errors.phoneNumbers?.message}</p>

            <label htmlFor="secundary-phone">Secundary Phone Number</label>
          <input type="text" id="secundary-phone" {...register("phoneNumbers.1", {
          })}/>
            <p className='error'>{errors.phoneNumbers?.message}</p>

            <div>
                <label>List of phone numbers</label>
                <div>
                    {fields.map((field, index) => {
                            return(
                                <div className='form-control' key={field.id}>
                                    <input 
                                    type="text" 
                                    {...register(`phNumbers.${index}.number` as const)}
                                    />
                                    {
                                        index > 0 && (
                                            <button type='button' 
                                            onClick={() => remove(index)}>Remove</button>
                                        )
                                    }
                                </div>
                            );
                        })
                    }
                    <button type='button' 
                    onClick={() => append({number: ""})}>Add Number</button>
                </div>
            </div>

            <label htmlFor="age">Age</label>
          <input type="number" id="age" {...register("age", {
            valueAsNumber: true,
            required: {
                value: true,
                message: "age is required"
            }
          })}/>
            <p className='error'>{errors.age?.message}</p>

            <label htmlFor="dob">Date of Birth</label>
          <input type="date" id="dob" {...register("dob", {
            valueAsDate: true,
            required: {
                value: true,
                message: "dob is required"
            }
          })}/>
            <p className='error'>{errors.dob?.message}</p>
  
          <button>Submit</button>
          <button type='button' onClick={handleGetValues}>Get Values</button>
        </form>
        <DevTool control={control}/>
      </div>
    );
  };