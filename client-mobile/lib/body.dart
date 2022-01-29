import 'package:expansion_tile_card/expansion_tile_card.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class BodyPage extends StatelessWidget {
  final GlobalKey<ExpansionTileCardState> cardA = new GlobalKey();
  final GlobalKey<ExpansionTileCardState> cardB = new GlobalKey();
  final GlobalKey<ExpansionTileCardState> cardC = new GlobalKey();
  @override
  Widget build(BuildContext context) {
    final ButtonStyle flatButtonStyle = TextButton.styleFrom(
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.all(Radius.circular(4.0)),
      ),
    );
    return ListView(
      shrinkWrap: true,
      children: <Widget>[
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 12.0),
          child: ExpansionTileCard(

            baseColor: Colors.blue[300],
            key: cardA,
            leading: CircleAvatar(child: Text('A')),
            title: Text('ATM. Khalilullah', style: TextStyle(fontSize: 11, color: Colors.black87)),
            subtitle: Text(
                'Which of the following is not a Java features? '
                'a) Dynamic '
                'b) Architecture Neutral '
                'c) Use of pointers '
                'd) Object-oriented ',
                style: TextStyle(fontSize: 15, height: 2, color: Colors.black)),
            children: <Widget>[
              Divider(
                thickness: 1.0,
                height: 2.0,
              ),
              Align(
                alignment: Alignment.centerLeft,
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16.0,
                    vertical: 8.0,
                  ),
                  child: Text(
                    """Ans C""",
                    style: Theme.of(context)
                        .textTheme
                        .bodyText2!
                        .copyWith(fontSize: 16),
                  ),
                ),
              ),
              ButtonBar(
                alignment: MainAxisAlignment.spaceAround,
                buttonHeight: 52.0,
                buttonMinWidth: 90.0,
                children: <Widget>[
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardB.currentState?.expand();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(
                          Icons.favorite,
                          color: Colors.pink,
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Like'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardB.currentState?.collapse();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.arrow_downward),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Dislike'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      // Container(
                      //   child: TextField(
                      //     decoration: InputDecoration(
                      //       border: OutlineInputBorder(),
                      //       hintText: 'Enter a search term',
                      //     ),
                      //   ),
                      // );
                      cardB.currentState?.expand();
                    },

                    child: Column(
                      children: <Widget>[
                        Icon(Icons.reply),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Reply'),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),


        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 12.0),
          child: ExpansionTileCard(
            key: cardB,
            expandedTextColor: Colors.red,
            title: Text('Nayeem Ahmed'),
            children: <Widget>[
              Divider(
                thickness: 1.0,
                height: 1.0,
              ),

              Align(
                alignment: Alignment.centerLeft,
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16.0,
                    vertical: 8.0,
                  ),
                  child: Text(
                    """Hi there, I'm a drop-in replacement for Flutter's ExpansionTile.

Use me any time you think your app could benefit from being just a bit more Material.

These buttons control the card above!""",
                    style: Theme.of(context)
                        .textTheme
                        .bodyText2!
                        .copyWith(fontSize: 16),
                  ),
                ),
              ),

              ButtonBar(
                alignment: MainAxisAlignment.spaceAround,
                buttonHeight: 52.0,
                buttonMinWidth: 90.0,
                children: <Widget>[
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.expand();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.arrow_downward),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Open'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.collapse();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.arrow_upward),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Close'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.toggleExpansion();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.swap_vert),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Toggle'),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),

        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 12.0),
          child: ExpansionTileCard(
            key: cardB,
            expandedTextColor: Colors.red,
            title: Text('Nayeem Ahmed'),
            children: <Widget>[
              Divider(
                thickness: 1.0,
                height: 1.0,
              ),

              Align(
                alignment: Alignment.centerLeft,
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16.0,
                    vertical: 8.0,
                  ),
                  child: Text(
                    """Hi there, I'm a drop-in replacement for Flutter's ExpansionTile.

Use me any time you think your app could benefit from being just a bit more Material.

These buttons control the card above!""",
                    style: Theme.of(context)
                        .textTheme
                        .bodyText2!
                        .copyWith(fontSize: 16),
                  ),
                ),
              ),

              ButtonBar(
                alignment: MainAxisAlignment.spaceAround,
                buttonHeight: 52.0,
                buttonMinWidth: 90.0,
                children: <Widget>[
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.expand();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.arrow_downward),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Open'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.collapse();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.arrow_upward),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Close'),
                      ],
                    ),
                  ),
                  TextButton(
                    style: flatButtonStyle,
                    onPressed: () {
                      cardA.currentState?.toggleExpansion();
                    },
                    child: Column(
                      children: <Widget>[
                        Icon(Icons.swap_vert),
                        Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2.0),
                        ),
                        Text('Toggle'),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),


      ],
    );
  }
}
