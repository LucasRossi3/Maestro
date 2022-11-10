import { useState, useEffect } from "react";

export const useCrud = (url) => {
    
    const [data,setData] = useState(null);
    const [config,setConfig] = useState(null);
    const [method,setMethod] = useState(null);
    const [callFetch,setCallFetch] = useState(false);

    const httpConfig = (data,method) => {
        if (method === "POST"){
            setConfig({
                method,
                headers: {"Content-type" : "apllication/json"},
                body: JSON.stringify(data),
            })
            
        }
        else if (method === "PUT"){
            setConfig({
                method,
                headers: {"Content-type" : "apllication/json"},
                body: JSON.stringify(data),
            })
        }
        else if (method === "DELETE"){
            setConfig({
                method,
                headers: {"Content-type" : "apllication/json"},
                body: JSON.stringify(data),
            })
        }
        else
        {
            setConfig({
                method: "GET",
                headers: {"Content-type" : "apllication/json"}
            })
        }
        setMethod(method)
    }

    useEffect(()=>{
        const fetchData = async ()=>{
            const response = await fetch(url);

            const json = await response.json();

            setData(json);
        };

        fetchData();
    },[url,callFetch])


    useEffect(()=>{
        const httpRequest = async ()=>{
            let fetchOptions = [url,config]

            const response = await fetch(...fetchOptions);

            const json = await response.json();

            setCallFetch(json);
        };

        httpRequest();
    },[url,method,config])



    return { data,  httpConfig }
}