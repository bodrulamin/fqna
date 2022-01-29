import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:pandabar/main.view.dart';
import 'package:pandabar/model.dart';

class BottomNavBar extends StatefulWidget {
  const BottomNavBar({Key? key}) : super(key: key);

  @override
  _BottomNavBarState createState() => _BottomNavBarState();
}

class _BottomNavBarState extends State<BottomNavBar> {
  @override
  Widget build(BuildContext context) {
    return PandaBar(
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
    );
  }
}
