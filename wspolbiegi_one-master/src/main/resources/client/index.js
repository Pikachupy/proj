window.onload =`` () => {
    const downloadBtn = document.getElementById("btn-download-redir") || document.createElement("button");
    downloadBtn.addEventListener("click", async (e) => await handleClick(e));
}

const handleClick = async (event) => {
    event.preventDefault();
    try {
        const res = await fetchRedirUrl();
        if (res && res.url) {
            window.location.href = res.url;
        }
    } catch(ex) {
        console.error(ex);
        alert(ex.message || "Nieznany błąd!");
    }
}

const fetchRedirUrl = async () => {
    const url = "http://localhost:8080/download";
    const resp = await fetch(url, {
        method: "GET",
        headers: {
            "Cache-Control": "no-cache"
        }
    });
    if (resp.status === 301) {
        // redirect, wszystko leci po http
        return {};
    } else {
        throw await resp.json();
    }
}