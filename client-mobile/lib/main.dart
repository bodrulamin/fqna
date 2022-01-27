import 'package:flutter/material.dart';
import 'package:pandabar/main.view.dart';
import 'package:pandabar/model.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        // Remove the debug banner
        debugShowCheckedModeBanner: false,
        title: 'Questionnaire',
        theme: ThemeData(
          primarySwatch: Colors.deepPurple,
        ),
        home: HomePage());
  }
}

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            floating: true,
            pinned: true,
            snap: false,
            centerTitle: false,
            title: Column(
              children: [
                Row(
                  children: [
                    ButtonTheme(
                      //minWidth: 200.0,
                      height: 40.0,
                      child: ElevatedButton(
                        onPressed: () {},
                        style: ElevatedButton.styleFrom(
                          primary: Colors.white,

                          padding: const EdgeInsets.all(7.5),

                          //textStyle: const TextStyle(fontSize: 20),
                        ),
                        child: const Icon(
                          Icons.filter_alt_outlined,
                          color: Colors.deepPurple,
                          size: 25,
                        ),
                      ),
                    ),
                    Expanded(
                      child: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Container(
                          width: double.infinity,
                          height: 40,
                          color: Colors.white,
                          child: const TextField(
                            textAlign: TextAlign.center,
                            decoration: InputDecoration(
                                hintText: 'Search for something',
                                suffixIcon: Icon(Icons.search)),
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),

            // title: const Center(
            //   child: Text('Questionnaire'),
            // ),
          ),

          SliverList(
            delegate: SliverChildListDelegate([
              Container(
                height: 150,
                child: const Center(
                  child: Card(
                    child: InkWell(
                      splashColor: Colors.grey,

                      child: SizedBox(
                        width: 350,
                        height: 80,
                        child: Text('1. what is java ?'),
                      ),
                    ),
                  ),
                ),
              ),
            ]),
          ),
        ],
      ),




      bottomNavigationBar: PandaBar(
        backgroundColor: Colors.deepPurple,
        buttonSelectedColor: Colors.white,
        buttonColor: Colors.white,

        buttonData: [
          PandaBarButtonData(id: 'Topics', icon: Icons.topic_outlined,  title: 'Topics'),
          PandaBarButtonData(id: 'Blue', icon: Icons.border_color, title: 'Blue'),
          PandaBarButtonData(
              id: 'Red', icon: Icons.account_balance_wallet, title: 'Red'),
          PandaBarButtonData(
              id: 'Yellow', icon: Icons.person_pin, title: 'Profile'),
        ],

        onChange: (id) {
          setState(() {});

        },
        onFabButtonPressed: () {


        },
      ),
    );
  }
}
