# encrypted-class-loader
This project aims to protect java codes with encrypted class loader approach.

Usage
=====
1- Run com.crypto.ClassEncryption.java to encrypt existing java classes. Path of class file should be defined in the main method. Programs generates encrypted class in under the path samefolder/encrypted

2- Run com.crypto.CryptoCodeProject.java to decrypt and run encrypted class file.

You might modify the code to store encrypted class in database. This project aims class loading and encryption/decryption procedures to be understandable.

License
=======
Copyright 2016 Sefik Ilkin Serengil

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
