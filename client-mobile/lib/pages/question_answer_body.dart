import 'package:expansion_tile_card/expansion_tile_card.dart';
import 'package:flutter/material.dart';

class QuestionAnswerBody extends StatefulWidget {
  const QuestionAnswerBody({Key? key}) : super(key: key);

  @override
  _QuestionAnswerBodyState createState() => _QuestionAnswerBodyState();
}

class _QuestionAnswerBodyState extends State<QuestionAnswerBody> {
  @override
  Widget build(BuildContext context) {


    return ListView(
      children: [for (int i = 0; i < 10; i++) QuestionCard()],
    );
  }
}

class QuestionCard extends StatelessWidget {
  const QuestionCard({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
        child: Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Column(
          children: [
            Icon(Icons.arrow_upward),
            Text("8"),
            Icon(Icons.arrow_downward),
          ],
        ),
        Expanded(
          child: Column(
            children: [
              Text(""
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                  ""),
            ],
          ),
        ),
        Image(
            image: AssetImage("assets/images/c.png"),
        height: 30,
          width: 30,
        )
      ],
    ));
  }
}
