import 'bootstrap/dist/css/bootstrap.css';

export function Blog() {
    const posts = [
        {
            id:1,
            title: "5 Best Crypto Performers During The 2022 Market Flop",
            slug: "5-best-crypto-performers-during-the-2022-market-flop",
            category: "Crypto News",
            updatedAt: "21 hours ago"
        },
        {
            id:2,
            title: " Top crypto funding stories of 2022  ",
            slug: "top-crypto-funding-stories-of-2022",
            category: "New Year Special",
            updatedAt: "a day ago"
        },
        {
            id:3,
            title: " 2023 will see the death of play-to-earn gaming ",
            slug: "2023-will-see-the-death-of-playtoearn-gaming",
            category: " Opinion",
            updatedAt: "a day ago"
        },
        {
            id:4,
            title: " US lawmakers under pressure following FTX collapse: Report  ",
            slug: "us-lawmakers-under-pressure-following-ftx-collapse-report",
            category: " News",
            updatedAt: "2 days ago"
        },
        {
            id:5,
            title: "A Crypto Holiday Special: Past, Present, And Future With Material Indicators",
            slug: "a-crypto-holiday-special-past-present-and-future-with-material-indicators",
            category: "Interviews",
            updatedAt: "2 days ago"
        }
    ]
    return (
        <>
            <h1 align="center">List Posts</h1>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Time</th>
                </tr>
                </thead>
                {
                    posts.map((p)=>(
                        <tbody>
                        <tr key={p.id}>
                            <td>{p.id}</td>
                            <td>{p.title}</td>
                            <td>{p.category}</td>
                            <td>{p.updatedAt}</td>
                        </tr>
                        </tbody>
                    ))
                }
            </table>
        </>

    )
    
}