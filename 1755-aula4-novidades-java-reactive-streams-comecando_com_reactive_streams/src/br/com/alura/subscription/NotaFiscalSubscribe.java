package br.com.alura.subscription;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

import java.util.concurrent.Flow;

public class NotaFiscalSubscribe implements Flow.Subscriber<NotaFiscal> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Chamando o onSubscribe");
        this.subscription = subscription;
        // Número de notas fiscais que seram processadas
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal notaFiscal) {
        NotaFiscalWSClient notaFiscalWSClient = new NotaFiscalWSClient();
        notaFiscalWSClient.enviar(notaFiscal);
        // Busca próxima nota fiscal (sem isso o processo não irá acabar)
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Processo finalizado!");
    }
}
