import 'package:client_mobile/pages/question_answer_body.dart';
import 'package:client_mobile/widgets/bottom_navigation.dart';
import 'package:client_mobile/widgets/titlebar.dart';
import 'package:flutter/material.dart';

class Home extends  StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: TitleBar(),
      ),
      body: QuestionAnswerBody(),
      bottomNavigationBar: BottomNavBar(),

    );
  }
}
