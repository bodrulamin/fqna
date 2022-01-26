import 'package:flutter/material.dart';

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
            title: Center(
              child: Text('Questionnaire'),
            ),
            bottom: AppBar(
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
                  child: Icon(Icons.filter_alt_outlined, color: Colors.deepPurple, size: 25,),
                ),
              ),
                      Expanded(
                        child: Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: Container(
                            width: double.infinity,
                            height: 40,
                            color: Colors.white,
                            child: TextField(
                              textAlign: TextAlign.center,
                              decoration: InputDecoration(
                                  hintText: 'Search for something',
                                  prefixIcon: Icon(Icons.search),
                                  suffixIcon: Icon(Icons.camera_alt)),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),

          // Other Sliver Widgets
          SliverList(
            delegate: SliverChildListDelegate([
              Container(
                height: 400,
                child: Center(
                  child: Text(
                    'questionnaire',
                  ),
                ),
              ),
              Container(
                height: 1000,
                color: Colors.pink,
              ),
            ]),
          ),
        ],
      ),
    );
  }
}
