import axios from "axios";

export default function ListPost({posts}) {

    return (
        <>
            <h1>LIST POST</h1>
            <table border={1}>
                <thead>
                <tr>
                    <td>ID</td>
                    <td>TITLE</td>
                    <td>CATEGORY</td>
                    <td>SLUG</td>
                    <td>ACTION</td>
                </tr>
                </thead>
                <tbody>
                {
                    posts ?
                        posts.map((p) => {
                            return (
                                <tr key={p.id}>
                                    <td>{p.id}</td>
                                    <td>{p.title}</td>
                                    <td>{p.category}</td>
                                    <td>{p.slug}</td>

                                </tr>
                            )
                        }) : ""
                }
                </tbody>
            </table>

        </>
    )
}
export const getStaticProps = async () => {
    const res = await axios.get("http://localhost:8080/posts");
    return {
        props: {
            posts: res.data
        }
    }
}