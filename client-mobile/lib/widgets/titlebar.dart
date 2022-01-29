import 'package:flutter/material.dart';

class TitleBar extends StatelessWidget {
  const TitleBar({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
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
    );
  }
}
