package com.pedrohucb.fitech.view.listexercicios.models

import com.pedrohucb.fitech.R

data class Exercicio(
    val imagem : Int,
    val tituloExercicio : String,
    val finalidadeExercicio : String,
    val dificuldadeExercicio : String,
    val id : Int
    val descricaoExercicio : String
)

object ExercicioRepositorySuperiores {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.sup_full_pushups_img, "Flexão Completa", "Peitoral, triceps e ombro", "Dificuldade: Média", 1, "Para tornar este exercício mais fácil: Realizar este exercício com um ligeiro declive pode torná-lo mais fácil. Isso é basicamente voltar às Flexões Inclinadas, mas com uma base a apenas um pé ou dois do chão (30-60 cm). Um banquinho ou um pufe encostado na parede funciona bem.\nPara tornar este exercício mais difícil: Realizar este exercício mais devagar pode torná-lo significativamente mais desafiador para alguns praticantes, especialmente aqueles que costumam depender do impulso."),
            Exercicio(R.drawable.sup_wall_pushup_img, "Flexão na parede", "Peitoral, tricpes e ombro", "Dificuldade: Fácil", 2, "Para tornar este exercício mais difícil: Realize este exercício em uma moldura de porta ou anéis de ginástica para aumentar a amplitude de movimento. Desça até não conseguir mais antes de subir novamente.\\nPara tornar este exercício mais fácil: Fazer isso de joelhos facilitará o exercício. No entanto, como flexões de parede são apenas um pouco mais desafiadoras do que abrir portas, você pode obter melhores resultados fazendo menos flexões de parede no início, em vez de torná-las mais fáceis."),
            Exercicio(R.drawable.sup_knee_pushups_img, "Flexão de joelhos", "Peitoral, triceps e ombro", "Dificuldade: Fácil", 3, "Para tornar este exercício mais fácil: Uma base mais alta torna este exercício mais fácil. Mesmo alguns blocos podem ajudar.\nPara tornar este exercício mais difícil: Agachar-se sobre os joelhos e levantar-se nas pontas dos pés torna este exercício mais desafiador."),
            Exercicio(R.drawable.sup_incline_pushups_img, "Flexão inclinada", "Peitoral, triceps e ombro", "Dificuldade: Fácil", 4, "To make this exercise easier: A higher base makes this exercise easier.\nTo make this exercise harder: A lower base makes this exercise harder."),
            Exercicio(R.drawable.sup_advanced_incline_pushups_img, "Flexão inclinada avançada", "Peitoral, triceps e ombro", "Dificuldade: Moderada", 5, "Para tornar este exercício mais difícil: Uma base mais baixa torna este exercício mais desafiador. Ou você pode aproximar as mãos.\nPara tornar este exercício mais fácil: Uma base mais alta facilita este exercício. Ou você pode fazer isso de joelhos, se tiver um objeto com altura equivalente à altura dos joelhos."),
            Exercicio(R.drawable.sup_narrow_pushups_img, "Flexão fechada", "Peitoral, triceps e ombro", "Dificuldade: Média/Dificil", 6, "Para tornar este exercício mais difícil: Aproximar as mãos uma da outra - até mesmo ao ponto em que uma mão fica em cima da outra - pode tornar este exercício mais desafiador.\nPara tornar este exercício mais fácil: Manter as mãos mais afastadas uma da outra facilita o exercício. Aproximá-las algumas polegadas uma da outra a cada poucas semanas pode ser uma maneira constante de progredir para as Flexões Estreitas.")
        )
    }
}

object ExercicioRepositoryInferiores {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.inf_assisted_squats_img, "Agachamento com apoio", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Fácil", 7, "Para facilitar este exercício: Auxiliar mais com os braços tornará este exercício mais fácil.\nPara tornar este exercício mais difícil: Auxiliar menos com os braços tornará este exercício mais desafiador. Conforme você fica mais forte, tente não usar assistência alguma na subida depois que as coxas estiverem na posição paralela. Isso basicamente corresponde à parte concêntrica dos Meio Agachamentos!"),
            Exercicio(R.drawable.inf_half_squats_img, "Agachamento Parcial", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Fácil/Médio", 8, "Para facilitar este exercício: Reduzir a profundidade do agachamento tornará este exercício mais fácil. Adicione um ou dois centímetros de profundidade sempre que se sentir pronto, e eventualmente conseguirá agachar até a posição paralela.\nPara tornar este exercício mais difícil: Agachar-se abaixo da posição paralela tornará este exercício mais desafiador e o conduzirá suavemente para a próxima etapa!"),
            Exercicio(R.drawable.inf_full_squat_img, "Agachamento Completo", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Médio", 9, "Para facilitar este exercício: Auxiliar-se para sair da posição mais baixa - a parte mais difícil - tornará este exercício mais fácil.\nPara tornar este exercício mais difícil: Agachar-se com os pés menos afastados do que a largura dos ombros tornará este exercício mais desafiador e o conduzirá suavemente para a próxima etapa!"),
            Exercicio(R.drawable.inf_assisted_one_leg_squats_img, "Agachamento de uma perna com apoio", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Difícil", 10, "Para tornar este exercício mais fácil: Ajudar mais com os braços facilitará este exercício. Ter a plataforma de assistência mais próxima tornará isso mais fácil.\n Para tornar este exercício mais difícil: Ajudar menos com os braços tornará este exercício mais difícil. Você pode tentar auxiliar com um braço de cada vez para ter um melhor controle sobre a dificuldade."),
            Exercicio(R.drawable.inf_one_leg_squats_img, "Agachamento de uma perna", "Quadríceps, glúteos e músculos próximos", "Dificuldade: Muito Difícil", 11, "Para tornar este exercício mais fácil: Não agachar completamente fará este exercício mais fácil. Conforme você fica mais forte, pode ir mais baixo! Pode ser útil usar as mãos pressionando no chão para ajudar a sair da parte inferior.\nPara tornar este exercício mais difícil: Faça muitas repetições (20+) com este exercício antes de tentar torná-lo mais difícil. Se você gosta de agachamentos em uma perna e deseja aumentar a dificuldade, pode tentar segurar um haltere enquanto os realiza. Pessoalmente, acho isso um pouco monótono."),
        )
    }
}

object ExercicioRepositoryAbdominais {
    fun getExercicios(): List<Exercicio> {
        return listOf(
            Exercicio(R.drawable.abd_knee_raises_img, "Elevação de joelhos", "Musculatura abdominal e lombar", "Dificuldade: Fácil", 12, "Para tornar este exercício mais fácil: Dobrar mais os joelhos facilitará este exercício.\nPara tornar este exercício mais difícil: Endireitar um pouco os joelhos tornará este exercício mais desafiador."),
            Exercicio(R.drawable.abd_advanced_knee_raises_img, "Elevação de joelhos avançada", "Musculatura abdominal e lombar", "Dificuldade: Fácil/Média", 13,"Para tornar este exercício mais fácil: Dobrar mais os joelhos facilitará este exercício.\nPara tornar este exercício mais difícil: Endireitar um pouco os joelhos tornará este exercício mais desafiador."),
            Exercicio(R.drawable.abd_full_leg_raises_img, "Elevação de pernas", "Musculatura abdominal e lombar", "Dificuldade: Média", 14, "Para facilitar este exercício: Manter um leve flexionamento nos joelhos tornará este exercício mais fácil. Com o tempo, estique as pernas. Fazer isso mais rapidamente também facilitará. Diminua a velocidade ao longo do tempo. Queremos ter controle sobre cada parte do nosso alcance de movimento.\nPara tornar este exercício mais difícil: Mover as pernas além da posição perpendicular ao chão tornará este exercício mais desafiador. Isso é o que exploraremos na nossa próxima etapa de progressão!"),
            Exercicio(R.drawable.abd_hanging_knee_raises_img, "Elevação de joelhos suspensa", "Musculatura abdominal e lombar", "Dificuldade: Média/Difícil", 15, "Para facilitar este exercício: Manter os joelhos dobrados durante todo o exercício tornará isso mais fácil. Tenha cuidado extra para não cair sobre os joelhos, o que poderia causar ferimentos graves.\nPara tornar este exercício mais difícil: Endireitar um pouco as pernas tornará este exercício mais desafiador e o conduzirá suavemente para a próxima etapa!"),
            Exercicio(R.drawable.abd_hanging_leg_raises_img, "Elevação de pernas suspensa", "Musculatura abdominal e lombar", "Dificuldade: Difícil", 16, "Para facilitar este exercício: Dobrar as pernas na subida e estendê-las na descida tornará este exercício mais fácil.\nPara tornar este exercício mais difícil: Aumentar a amplitude de movimento deste exercício ao elevar as pernas acima da posição paralela tornará o exercício mais desafiador! Fazer uma pausa nessa posição pode até desafiar atletas avançados. Isso o conduzirá suavemente para a próxima etapa."),
        )
    }
}
