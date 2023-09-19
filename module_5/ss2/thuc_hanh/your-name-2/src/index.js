import ReactDom from "react-dom/client";
const name = "Nhan Tri";

const root = ReactDom.createRoot(document.getElementById("root"));
root.render(
    <h1 style={{textAlign:"center"}}>
        {name}
    </h1>

);