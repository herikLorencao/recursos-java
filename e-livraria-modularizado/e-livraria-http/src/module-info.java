module e.livraria.http {
    requires java.net.http;
    requires transitive e.livraria.modelo;
    exports br.com.alura.http.dao;
}