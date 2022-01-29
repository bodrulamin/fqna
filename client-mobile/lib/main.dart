import 'package:client_mobile/profile.dart';
import 'package:flutter/material.dart';
import 'package:pandabar/main.view.dart';
import 'package:pandabar/model.dart';
import 'body.dart';
import 'home.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        routes: {
          '/profile': (context) => Profile(),
        },
        // Remove the debug banner
        debugShowCheckedModeBanner: false,
        title: 'Questionnaire',
        theme: ThemeData(
          primarySwatch: Colors.deepPurple,
        ),
        home: Home());
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
            delegate: SliverChildListDelegate([BodyPage()]),
          ),
        ],
      ),
      bottomNavigationBar: PandaBar(
        backgroundColor: Colors.deepPurple,
        buttonSelectedColor: Colors.white,
        buttonColor: Colors.white,

        buttonData: [
          PandaBarButtonData(
              id: 'Topics', icon: Icons.topic_outlined, title: 'Topics'),
          PandaBarButtonData(
              id: 'Blue', icon: Icons.border_color, ),
          PandaBarButtonData(
              id: 'Red', icon: Icons.account_balance_wallet, ),
          PandaBarButtonData(
            id: 'profile',
            icon: Icons.person_pin,
            title: 'Profile',
          ),
        ],
        onChange: (id) {
          if (id == 'Topics') {
            showModalBottomSheet(
                context: context,
                builder: (context) {
                  return Container(
                    height: 250,
                    child: Column(
                      children: <Widget>[
                        Card(
                          child: ListTile(
                            title: Text("C#"),
                            subtitle: Text("Hello World"),
                            leading: CircleAvatar(
                                backgroundImage:
                                    AssetImage("assets/images/c.png")),
                            trailing: Icon(Icons.adjust),
                          ),
                        ),
                        Card(
                            child: ListTile(
                          title: Text("JAVA"),
                          subtitle: Text("Hello World"),
                          leading: CircleAvatar(
                              backgroundImage:
                                  AssetImage("assets/images/226777.png")),
                          trailing: Icon(Icons.description),
                        )),
                        Card(
                          child: ListTile(
                            title: Text("GAVE"),
                            subtitle: Text("Hello World"),
                            trailing: Icon(Icons.question_answer),
                            leading: CircleAvatar(
                                backgroundImage:
                                    AssetImage("assets/images/graphics.jpg")),
                          ),
                        ),
                      ],
                    ),
                  );
                });
          }
          if (id == 'profile') {
            Navigator.of(context).pushNamed('/profile');
          }

          setState(() {});
        },
        onFabButtonPressed: () {},
      ),
    );
  }
}
