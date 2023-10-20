enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String) {
    val formacoesInscritas = mutableListOf<Formacao>()

    fun inscreverNaFormacao(formacao: Formacao) {
        formacao.matricular(this)
        formacoesInscritas.add(formacao)
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 90)

    val formacao1 = Formacao("Desenvolvimento de Software")
    val formacao2 = Formacao("Algoritmos Avançados")

    formacao1.adicionarConteudo(conteudo1)
    formacao2.adicionarConteudo(conteudo2)

    val usuario1 = Usuario("João Silva")
    val usuario2 = Usuario("Maria Santos")

    usuario1.inscreverNaFormacao(formacao1)
    usuario2.inscreverNaFormacao(formacao2)

    println("Usuários inscritos na formação 1:")
    formacao1.inscritos.forEach { println(it.nome) }

    println("Usuários inscritos na formação 2:")
    formacao2.inscritos.forEach { println(it.nome) }
}