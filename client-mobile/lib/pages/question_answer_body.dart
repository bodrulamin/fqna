import 'package:expansion_tile_card/expansion_tile_card.dart';
import 'package:flutter/material.dart';

class QuestionAnswerBody extends StatefulWidget {
  const QuestionAnswerBody({Key? key}) : super(key: key);

  @override
  _QuestionAnswerBodyState createState() => _QuestionAnswerBodyState();
}

class _QuestionAnswerBodyState extends State<QuestionAnswerBody> {
  late List myList;
  ScrollController _scrollController = ScrollController();
  int currentMax = 10;

  @override
  void initState() {
    super.initState();
    myList = List.generate(20, (i) => "Item : ${i + 1}");
    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        _getMoreData();
      }
    });
  }

  _getMoreData() {
    print("get more data");
    for (int i = currentMax; i < currentMax + 10; i++) {
      myList.add("Item : ${i + 1}");
    }
    currentMax = currentMax + 10;
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      controller: _scrollController,
      itemExtent: 80,
      itemBuilder: (context, i) {
        return QuestionCard();
      },
      itemCount: myList.length + 1,
      //children: [for (int i = 0; i < 10; i++) QuestionCard()],
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
              Icon(Icons.arrow_drop_up_rounded, size: 23.0),
              Text("8"),
              Icon(Icons.arrow_drop_down_rounded, size: 23.0),
            ],
          ),
          Expanded(
            child: Column(
              children: [
                Text(""
                    "updown asdfdsafsdf a fdadsfsdfsdafsadf sdfasdfsdafdsfdsf"
                    ""),
              ],
            ),
          ),
          Image(
            image: AssetImage("assets/images/226777.png"),
            height: 30,
            width: 30,
          )
        ],
      )
    );
  }
}
