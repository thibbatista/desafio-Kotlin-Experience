import java.util.Scanner

//classes na template do desafio com algumas simples modificações
enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    //lista mutável das formações para serem iteradas e listadas para o usuário
    val formacoes = mutableListOf<Formacao>()

    //criando as formações e conteúdos e armazenando-os na lista mutável
    val conteudosKt: List<ConteudoEducacional> = listOf<ConteudoEducacional>(ConteudoEducacional("O poder das funções em kotlin", 120),
        ConteudoEducacional("Paradigma de orientação a objetos em kotlin", 60))
    val expKotlin: Formacao = Formacao("Experiência Kotlin", conteudosKt,  Nivel.BASICO )
    formacoes.add(expKotlin)

    val conteudosJava: List<ConteudoEducacional> = listOf(ConteudoEducacional("Introdução ao Java", 120), ConteudoEducacional("Estruturas de Repetição em java", 120))
    val introJava: Formacao = Formacao("Introdução ao Java", conteudosJava, Nivel.BASICO)
    formacoes.add(introJava)

    val conteudosC: List<ConteudoEducacional> = listOf(ConteudoEducacional("Introdução à linguagem C"), ConteudoEducacional("Paradigma de orientação a objetos em C", 240))
    val linguagemC: Formacao = Formacao("Imersão na Linguagem C", conteudosC, Nivel.AVANÇADO)
    formacoes.add(linguagemC)

    val conteudosPy: List<ConteudoEducacional> = listOf(ConteudoEducacional("Introdução ao Python", 240), ConteudoEducacional("análise de dados com Python ", 120))
    val bootPy: Formacao = Formacao("Bootcamp de Python", conteudosPy, Nivel.INTERMEDIARIO)
    formacoes.add(bootPy)

    //início do diálogo com o usuário e listagem das formações disponíveis
    println("Bem-vindo ao ecossistema DIO, conheça as nossas formações do momento abaixo: ")
    for (formacao in formacoes) println("${formacoes.indexOf(formacao) + 1} - ${formacao.nome}")

    //recebendo o nome do usuário e armazenando na classe
    println("Qual o teu nome? ")
    val input = Scanner(System.`in`)
    val userName = input.next().toString()
    val user = Usuario(userName)

    //recebendo qual formação o usuário deseja se matricular
    println("Qual formação deseja fazer?(digite de 1 - 4 segundo a formação desejada ")

    //realizando a matricula na formação, de acordo com a escolha do usuário
    when(input.nextInt()){
        1 -> expKotlin.matricular(user)
        2 -> introJava.matricular(user)
        3 -> linguagemC.matricular(user)
        4 -> bootPy.matricular(user)
        else -> error("SOMENTE NÚMEROS DE 1 - 4")
    }

    println("Parabéns, você finalizou sua mtricula e já poode aproveitar a formação escolhida!")
    return


    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}